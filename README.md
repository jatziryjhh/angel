<p align="center">
  <img src="https://imgur.com/zrfRAqB.png" alt="certificados-ssl" width="400"/>
</p>

<h1 align="center">🌸 Spring Boot + Certificados SSL 🌸</h1>

<p align="center">
  🔐 Aprende a generar tus propios certificados SSL para que tu app corra en HTTPS como todo un profesional.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/SpringBoot-3.2.5-brightgreen?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/OpenSSL-v1.1-blue?style=for-the-badge&logo=openssl" />
  <img src="https://img.shields.io/badge/Hecho%20con%20❤️%20por-Jatz-ff69b4?style=for-the-badge" />
</p>

---

## ✨ ¿Qué vamos a hacer?

- Generar certificados `.key` y `.cer`
- Convertirlos a un `.p12` (keystore)
- Configurar Spring Boot para usar HTTPS
- Acceder a Swagger con conexión segura 💅🏼

---

## 🔨 Comandos para generar certificados

```bash
openssl req -x509 -newkey rsa:2048 -nodes -keyout class9B.key -out class9B.cer -days 20
````

**Cuando te los pida, llena los campos así:**

```
Country Name (2 letter code) [AU]: MX
State or Province Name (full name) [Some-State]: Morelos
Locality Name (eg, city) []: Emiliano Zapata
Organization Name (eg, company) [Internet Widgits Pty Ltd]: UTEZ
Organizational Unit Name (eg, section) []: DATID
Common Name (e.g. server FQDN or YOUR name) []: localhost
Email Address []: correo7@utez.edu.mx
```

Ahora convierte los certificados a un keystore:

```bash
openssl pkcs12 -export -in class9B.cer -inkey class9B.key -out keystore.p12 -name springboot -certfile class9B.cer -passout pass:root
```

---

## 📁 Configura tu `application.properties`

```properties
# Configuración de SSL
server.ssl.enabled=true
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-type=PKCS12
server.ssl.key-alias=springboot
server.ssl.key-store-password=root

# Puerto seguro
server.port=8080

# Extra
spring.application.name=unidad3
```

> Asegúrate de poner el archivo `keystore.p12` dentro de `src/main/resources`.

---

## 🧪 Prueba tu API en Swagger

### 🔐 URL Segura

[https://localhost:8080/swagger-ui/index.html](https://localhost:8080/swagger-ui/index.html)

> ⚠️ Dale clic en "**Avanzado**" → "**Aceptar riesgo y continuar**".

### ⚠️ URL Insegura (si usas HTTP)

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 💡 Notas extra

* Si cambiaste la contraseña del `keystore`, recuerda actualizarla en `application.properties`.
* Puedes cambiar el puerto (`server.port`) si tienes algo más corriendo en el 8080.
* Si te sale error al arrancar, revisa bien los paths y las contraseñas del `.p12`.

---

## 🎀 Créditos

**Hecho con amor por Jatz 💖 y chat**
*"Aprender Spring y verse bien haciéndolo 😎"*

```
