esto es para los certificados
openssl req -x509 -newkey rsa:2048 -nodes -keyout class9B.key -out class9B.cer -days 20
MX
Morelos
Emiliano Zapata
UTEZ
DATID
localhost
20223tn127@utez.edu.mx

openssl pkcs12 -export -in class9B.cer -inkey class9B.key -out keystore.p12 -name springboot -certfile class9B.cer -passout pass:root

url segura con certificados:
https://localhost:8080/swagger-ui/index.html
dale en avanzado
url insegura con certificados:
http://localhost:8080/swagger-ui/index.html
