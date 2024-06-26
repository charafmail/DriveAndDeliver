# utilise l'image de base openjdk avec la version 21
FROM openjdk:21-oracle

# Cree ce volume afin d'eviter d'ecrire dans le conteneur (risque qu'il soit supprimer et perdre les informations)
VOLUME /tmp

# copier les jar de mom application spring boot dans le jar app.jar
COPY target/*.jar app.jar

# Execution des commande
ENTRYPOINT ["java","-jar","app.jar"]