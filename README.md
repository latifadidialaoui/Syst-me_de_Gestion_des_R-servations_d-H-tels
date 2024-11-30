# Syst-me_de_Gestion_des_R-servations_d-H-tels
# Contexte
Une plateforme de réservation d’hôtels souhaite implémenter une API qui permet de gérer les
opérations suivantes :
1. Créer une réservation : Les utilisateurs soumettent des informations sur le client, les dates de
séjour, et les préférences de chambre.
2. Consulter une réservation : L’API récupère les informations détaillées d’une réservation
existante.
3. Modifier une réservation : Les utilisateurs peuvent mettre à jour les dates ou les informations
client.
4. Supprimer une réservation : Une réservation peut être annulée par un utilisateur ou un
administrateur.
Le système doit prendre en charge des millions de requêtes et être compatible avec des
environnements multi-utilisateurs. Il doit également fonctionner efficacement pour des volumes de
données variables (petits, moyens et grands messages).
# Objectifs de l'Étude
1. Comparer REST, SOAP, GraphQL, et gRPC dans un scénario réaliste en termes de :
o Performances (latence, débit, consommation des ressources).
o Scalabilité (capacité à gérer des charges croissantes).
o Simplicité d’implémentation.
o Sécurité et flexibilité.
2. Fournir des recommandations sur la technologie la plus adaptée à différents cas d’usage.
# Détails de l'Implémentation
   # 1. Backend :
   o Implémenté avec Spring Boot pour REST et SOAP.
   o Utilisation de Apollo Server pour GraphQL.
   o Utilisation de gRPC (Java gRPC library).
   o Hébergement sur un serveur local ou cloud avec des configurations identiques.
   # 2. Base de Données :
   o MySQL ou PostgreSQL pour stocker les données des réservations.
   o Les mêmes requêtes SQL sont utilisées pour garantir une équité dans la comparaison.   
