# PATRONES ARQUITECTURALES
En este Laboratorio se utilizo Docker para correr un servicio de logs que se conectan a mongoDB y un servidor web con un balanceador de carga que envia el log a los diferentes instancias de logservices. Tambien desplegaremos la aplicación en la nube con una instancia EC2 de AWS.

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



https://github.com/NicolasCastro9/AREP_LAB06.git



cd awsLab


mvn clean install

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/f81441e3-615c-49a7-945f-558edf149b89)



 docker-compose up -d

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/efaa1682-3686-41ae-adf6-f21964ef8e21)

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/0622e99f-115b-468a-8cf0-0c7260cc6fa7)


http://localhost:35000/


![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/ec32f023-bb2f-4921-921c-986abd366421)

![image](https://github.com/NicolasCastro9/AREP_LAB06/assets/98556822/cfac9d86-dd3a-42cc-b2fa-0a4f35be5e20)




sudo yum install git

git clone https://github.com/NicolasCastro9/AREP_LAB06.git

sudo yum install maven

sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose

sudo usermod -aG docker $USER

sudo chmod +x /usr/local/bin/docker-compose



