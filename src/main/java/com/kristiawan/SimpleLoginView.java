package com.kristiawan;

import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by kal on 26/11/16.
 */
public class SimpleLoginView extends CustomComponent implements View, Button.ClickListener {

    public static final String NAME = "Login";

    private final TextField userName;
    private final PasswordField password;
    private final Button btnLogin;

    public SimpleLoginView() {
        setSizeFull();

        userName = new TextField("Username");
        userName.setWidth("300px");
        userName.setInputPrompt("Your username (eg. joe@email.com)");
        userName.addValidator(new EmailValidator("Email salah!"));
        userName.setInvalidAllowed(false);
        userName.setRequired(true);
        userName.setNullRepresentation("");

        password = new PasswordField("Password");
        password.setInputPrompt("Your passsword");
        password.setWidth("300px");
        password.addValidator(new PasswordValidator());
        password.setValue("");
        password.setRequired(true);
        password.setNullRepresentation("");


        btnLogin = new Button("Login", this);
        btnLogin.setStyleName(ValoTheme.BUTTON_PRIMARY);

        VerticalLayout vLayout = new VerticalLayout(userName, password, btnLogin);
        vLayout.setSpacing(true);
        vLayout.setMargin(true);
        vLayout.setStyleName(Reindeer.LAYOUT_BLACK);
        vLayout.setSizeUndefined();

        Panel loginPanel = new Panel("Please Login");
        loginPanel.setContent(vLayout);
        loginPanel.setStyleName(ValoTheme.PANEL_BORDERLESS);
        loginPanel.setSizeUndefined();

        //root Layout
        VerticalLayout  viewLayout = new VerticalLayout(loginPanel);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        setCompositionRoot(viewLayout);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        userName.focus();
    }

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        Notification.show("Berhasil Login!");
        getUI().getNavigator().navigateTo(DashboardView.NAME);
    }

    public static final class PasswordValidator extends AbstractValidator<String> {

        public PasswordValidator() {
            super("The password provided is not valid");
        }

        @Override
        protected boolean isValidValue(String s) {
            if (s != null
                    && (s.length() < 8 || !s.matches(".*\\d.*"))) {
                return false;
            }
            return true;
        }

        @Override
        public Class<String> getType() {
            return String.class;
        }
    }
}
