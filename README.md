# PATRONES ARQUITECTURALES
En este Laboratorio utilizaremos Docker para correr un servicio de logs que se conectan a mongoDB y un servidor web con un balanceador de carga que envia el log a los diferentes instancias de logservices. Tambien desplegaremos la aplicación en la nube con una instancia EC2 de AWS.

# Clases
RoundRobin.java: Esta clase implementa el algoritmo RoundRobin, inicia un servidor web simple que escucha en un puerto específico y responde a dos rutas diferentes: una ruta devuelve un mensaje estático y la otra ruta realiza alguna operación de registro basada en un parámetro de consulta.

LogService.java:  implementa un servicio web que permite registrar mensajes en una base de datos MongoDB y consultar los últimos registros registrados.

HTTPConnection.java: Clase que proporciona funcionalidad para realizar conexiones HTTP con servidores de registro de logs utilizando el algoritmo de balanceo de carga Round Robin


# Pre-Requisitos
Java: Es un lenguaje de programación de propósito general orientado a objetos, portátil y muy versátil.

Maven: Es una herramienta que maneja el ciclo de vida del programa.

Git: Es un sistema de control de versiones distribuido (VCS).

Docker: Es un proyecto de código abierto que automatiza el despliegue de aplicaciones dentro de contenedores de software.

# Dependencias

Spark Java (Spark Core): marco web ligero para Java que permite construir aplicaciones web rápidas y sencillas. Proporciona un enfoque simple y expresivo para manejar solicitudes HTTP y crear rutas para manipular datos.

SLF4J API: interfaz de registro de eventos para aplicaciones Java. Proporciona una abstracción sobre varios sistemas de registro, permitiendo a los desarrolladores cambiar fácilmente de un sistema de registro a otro sin cambiar el código de la aplicación.

SLF4J Simple: implementación simple de SLF4J que proporciona capacidades básicas de registro de eventos. Es útil para proyectos pequeños o de prueba donde no se necesita una configuración de registro compleja.

MongoDB Java Driver: El controlador de MongoDB para Java proporciona la funcionalidad necesaria para interactuar con una base de datos MongoDB desde una aplicación Java. Permite realizar operaciones de lectura y escritura en la base de datos, así como también manipular colecciones y documentos MongoDB de manera programática desde Java.

# INSTRUCCION DE USO

 1. Clona el repositorio en tu máquina local:

```
git clone https://github.com/NicolasCastro9/AREP_LAB06.git
```

2. En la consola de comandos navegar hasta el directorio donde se encuentra el pom del proyecto

```
cd awsLab
```

3. Ejecuta el siguiente comando para compilar el proyecto y descargar las dependencias definidas en el archivo

```
mvn clean install
```
![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/f81441e3-615c-49a7-945f-558edf149b89)

4.  Abrimos la aplicación de docker e iniciamos los contenedores definidos en el archivo docker-compose.yml en modo daemon con el siguiente comando

```
 docker-compose up -d
```

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/efaa1682-3686-41ae-adf6-f21964ef8e21)

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/0622e99f-115b-468a-8cf0-0c7260cc6fa7)

5. Ingresamos a la siguiente URL y revisamos que la aplicación este funcionando

http://localhost:35000/

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/ec32f023-bb2f-4921-921c-986abd366421)

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/cfac9d86-dd3a-42cc-b2fa-0a4f35be5e20)



# ARQUITECTURA Y DISEÑO:

Arquitectura de Microservicios: La aplicación está compuesta por varios servicios que se ejecutan de forma independiente y colaboran entre sí para proporcionar la funcionalidad completa

Modelo-Vista-Controlador (MVC): se emplea principalmente debido a la estructura del código y la forma en que Spark Java, el framework utilizado, está diseñado para trabajar. 


# Construido con

Java: plataforma informática de lenguaje de programación

SparkJava: microframework web para Java que facilita la creación de aplicaciones web simples y rápidas

MongoDB: base de datos NoSQL orientada a documentos

Maven: framework de gestión de proyectos de software

Docker: sistema operativo para contenedores


# DESPLIEGUE EN AWS


https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/dac86ccc-7ff0-4cae-a200-45c2d5722a00





sudo yum install git

git clone https://github.com/NicolasCastro9/AREP_LAB06.git

sudo yum install maven

sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose

sudo usermod -aG docker $USER

sudo chmod +x /usr/local/bin/docker-compose



