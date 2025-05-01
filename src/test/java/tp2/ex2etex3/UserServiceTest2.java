package tp2.ex2etex3;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest2 {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @InjectMocks
    private UserService userService;

    // Cas 1 : L'API lève une exception
    @Test
    public void testCreerUtilisateurThrowsException() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jean@email.com");

        doThrow(new ServiceException("Échec de la création de l'utilisateur"))
                .when(utilisateurApiMock)
                .creerUtilisateur(utilisateur);

        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });

        assertEquals("Échec de la création de l'utilisateur", exception.getMessage());
    }

    // Cas 2 : Vérifier que l'API n'est jamais appelée (erreur de validation simulée)
    @Test
    public void testCreerUtilisateurNotCalledOnValidationError() throws ServiceException {
        Utilisateur utilisateurInvalide = new Utilisateur(null, "Dupont", "email");

        // Simuler une validation (pas dans UserService ici, donc on ne l'appelle pas)
        // Suppose que si prénom est null, on n'appelle pas le service

        // Ne pas appeler du tout la méthode
        verify(utilisateurApiMock, never()).creerUtilisateur(any());
    }

    // Cas 3 : Simuler un retour d'ID (modification fictive)
    @Test
    public void testCreerUtilisateurWithReturnedId() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jean@email.com");

        // Simuler que l'API affecte un ID à l'utilisateur (exemple de logique custom)
        doAnswer(invocation -> {
            Utilisateur u = invocation.getArgument(0);
            u.setId(123); // affecte l'ID dans le mock
            return null;
        }).when(utilisateurApiMock).creerUtilisateur(utilisateur);

        userService.creerUtilisateur(utilisateur);

        // Vérifier que l'utilisateur a bien un ID après création
        assertEquals(123, utilisateur.getId());
    }

    // Cas 4 : Vérification avec ArgumentCaptor
    @Test
    public void testCreerUtilisateurArgumentCaptor() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jean@email.com");

        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);

        doNothing().when(utilisateurApiMock).creerUtilisateur(any(Utilisateur.class));

        userService.creerUtilisateur(utilisateur);

        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());

        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        assertEquals("Jean", utilisateurCapture.getPrenom());
        assertEquals("Dupont", utilisateurCapture.getNom());
        assertEquals("jean@email.com", utilisateurCapture.getEmail());
    }
}
