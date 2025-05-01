tp2-partie1
exo4
1. Quels objets dont dépend la classe Jeu sont forcément mockés dans un test pour automatiser jouer ? Pourquoi ?
Les objets à mocker sont :

De → pour contrôler le résultat des dés, sinon le test est non déterministe.

Joueur → pour contrôler les interactions (mise(), debiter(), crediter()), sinon on ne peut pas simuler un joueur insolvable ou vérifier les crédits/débits.

Banque → pour contrôler les interactions (debiter(), crediter(), est_solvable()), sinon on ne peut pas simuler la solvabilité de la banque.

Mocker ces dépendances est indispensable pour rendre les tests automatiques, rapides et reproductibles.

2. Lister les scénarios (classes d’équivalence) pour tester jouer
Jeu fermé → exception
→ estOuvert() = false → doit lever JeuFermeException.

Joueur insolvable → arrêt sans lancer les dés
→ joueur.debiter() lève DebitImpossibleException.

Joueur perd (somme des dés ≠ 7)
→ joueur débité, banque créditée, pas de gain.

Joueur gagne (somme des dés = 7), banque solvable après gain
→ joueur crédité (2 × mise), banque débité (2 × mise), le jeu reste ouvert.

Joueur gagne (somme des dés = 7), banque insolvable après gain
→ joueur crédité (2 × mise), banque débité (2 × mise), le jeu ferme.

4. Test le plus simple : jeu fermé
C’est un test d’état car on vérifie l’état de l’objet (estOuvert() = false) et qu’il lève une exception, pas des interactions.

5. Tester le cas joueur insolvable
On configure le mock joueur.debiter() pour qu’il lève DebitImpossibleException.
Pour vérifier que les dés ne sont pas lancés, on vérifie qu’aucune interaction n’a eu lieu avec les dés (par exemple, méthode verifyNoInteractions(de1) en Mockito).

C’est un test d’interaction, car on vérifie que certaines méthodes ne sont pas appelées.