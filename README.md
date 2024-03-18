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


6. generamos el javadock

   ```
   mvn javadoc:javadoc
   ```

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

1. Creamos una instancia EC2 con Amazon Linux como imagen
   
   ![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/641ba990-e6e1-4154-b51e-39293bb2dae5)

2. Creamos una nueva regla de entrada

   ![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/5e978edf-751b-474b-a69c-c92e8564cef5)

3. En la consola de comandos vamos a la carpeta donde guardamos la llave publica e ingresamos a la instancia por SSH

   ![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/c42d4d11-a122-4032-b6ca-42d343e676ab)

4. Instalamos GIT
   ![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/435025b6-3c99-45ce-973f-6685643a41cf)

5. Clonamos el repositorio en la instancia
   
   ![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/d1f42958-4f14-4751-b61a-450e746de2eb)

6. Instalamos Maven

 ![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/66cf6d19-33dd-4706-ab96-6ed278c38e93)


7. Instalamos docker

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/c308ef9e-4b82-4fa9-b1a6-0163ca77eebd)

8. Inicializamos el servicio de docker

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/29b7bdd2-5dca-4906-8d81-b24980b09a21)

9. Descargamos docker-compose

```
sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
```

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/a75de03e-b438-47c3-9513-fd68ab81e408)

10. agregamos al usuario actual al grupo docker

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/24b55914-a947-45fe-b67e-c2b6c7516bff)

11. otorgamos permisos de ejecución al archivo docker-compose ubicado en /usr/local/bin
    
![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/8eded1e2-25d0-4d60-b715-28212fa9f325)

12. Ingresamos a la carpeta donde esta el pom e ingresamos el comando pra instalar las dependencias

```
mvn clean install
```

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/b7db671a-e02a-47f4-96df-8f1a4d79fa91)

13. Ejecutamos la aplicación de Docker Compose en segundo plano:

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/5479a8f6-a374-4417-ab01-407458a95cc2)


14. Ya podemos ver la instancia desplegada con la aplicación:

# VIDEO
https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/dac86ccc-7ff0-4cae-a200-45c2d5722a00





# Autor
Nicolas Castro Jaramillo

# Licencia
Este proyecto está bajo la licencia MIT.




