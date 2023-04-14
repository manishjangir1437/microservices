# Microservices with Eureka Server and inter communication with MTLS between all components.

# GENERATE CERTIFICATE WITH PRIVATE KEY AND ADD TO JKS
keytool -genkey -alias eureka -storetype JKS -keyalg RSA -keysize 2048 -keystore eureka.jks -validity 3650 -dname "CN=Manish Jangir,OU=NT,O=Neosoft,L=Mumbai,ST=Maharashtra,C=IN" -ext "SAN:c=DNS:localhost,IP:127.0.0.1"
keytool -genkey -alias product -storetype JKS -keyalg RSA -keysize 2048 -keystore product.jks -validity 3650 -dname "CN=Manish Jangir,OU=NT,O=Neosoft,L=Mumbai,ST=Maharashtra,C=IN" -ext "SAN:c=DNS:localhost,IP:127.0.0.1"
keytool -genkey -alias order -storetype JKS -keyalg RSA -keysize 2048 -keystore order.jks -validity 3650 -dname "CN=Manish Jangir,OU=NT,O=Neosoft,L=Mumbai,ST=Maharashtra,C=IN" -ext "SAN:c=DNS:localhost,IP:127.0.0.1"

# EXTRACT CERTIFICATE FROM ABOVE JKS
keytool -exportcert -alias eureka -keystore eureka.jks -file eureka.cer
keytool -exportcert -alias product -keystore product.jks -file product.cer
keytool -exportcert -alias order -keystore order.jks -file order.cer

# NOW SWAP THE CERTIFICATES FOR MTLS
keytool -importcert -alias order -keystore eureka.jks -file order.cer
keytool -importcert -alias product -keystore eureka.jks -file product.cer

keytool -importcert -alias eureka -keystore product.jks -file eureka.cer
keytool -importcert -alias order -keystore product.jks -file order.cer

keytool -importcert -alias product -keystore order.jks -file product.cer
keytool -importcert -alias eureka -keystore order.jks -file eureka.cer

# CREATE CERTIFICATE FOR ACCESSING THE API's
keytool -genkey -alias consumer -storetype JKS -keyalg RSA -keysize 2048 -keystore consumer.jks -validity 3650 -dname "CN=Manish Jangir,OU=NT,O=Neosoft,L=Mumbai,ST=Maharashtra,C=IN" -ext "SAN:c=DNS:localhost,IP:127.0.0.1"

# EXTRACT CERTIFICATE FROM ABOVE JKS
keytool -exportcert -alias consumer -keystore consumer.jks -file consumer.cer

# ADD ABOVE CERTIFICATE IN order.jks, product.jks and eureka.jks
keytool -importcert -alias consumer -keystore eureka.jks -file consumer.cer
keytool -importcert -alias consumer -keystore product.jks -file consumer.cer
keytool -importcert -alias consumer -keystore order.jks -file consumer.cer

# CONVERT ABOVE JKS TO P12 FOR BROWSER IMPORT
keytool -importkeystore -srckeystore consumer.jks -srcstoretype JKS -deststoretype PKCS12 -destkeystore consumer.p12

# JKS's are now ready to use
