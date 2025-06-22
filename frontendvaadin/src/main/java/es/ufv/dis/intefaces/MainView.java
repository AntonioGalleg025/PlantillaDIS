package es.ufv.dis.front.final2025.intefaces;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import es.ufv.dis.front.final2025.model.Usuario;
import es.ufv.dis.front.final2025.services.Servicio;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired Servicio service) {



        Grid<Usuario> grid = new Grid<>();
        grid.addColumn(Usuario::getNombre).setHeader("Nombre");
        grid.addColumn(Usuario::getApellidos).setHeader("Apellidos");
        grid.addColumn(Usuario::getNif).setHeader("NIF");
        grid.addColumn(Usuario::getEmail).setHeader("Email");
        grid.addColumn(new ComponentRenderer<>(usuario -> {
            Button editarButton = new Button("Editar");
            editarButton.addClickListener(event -> {
                // Lógica para editar este usuario específico
                service.editarUsuario(usuario); // Este método debe estar definido
                grid.setItems(service.getUsuarios()); // Actualizar la lista en el Grid
            });
            return editarButton;
        })).setHeader("Editar");

        // Configurar los elementos iniciales del Grid
        grid.setItems(service.getUsuarios());

        // Agregar el Grid al contenedor
        add(grid);

    }
}
