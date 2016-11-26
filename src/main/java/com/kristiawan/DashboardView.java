package com.kristiawan;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

/**
 * Created by kal on 26/11/16.
 */
public class DashboardView extends CustomComponent implements View{
    public static final String NAME = "Dashboard";

    public DashboardView() {
        setSizeFull();
        HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();

        VerticalLayout verticalLayout = new VerticalLayout();
        Panel panel = new Panel("Menu");
        verticalLayout.addComponent(panel);

        horizontalSplitPanel.setFirstComponent(new MenuBar());
        horizontalSplitPanel.setSecondComponent(verticalLayout);
        horizontalSplitPanel.setSizeFull();
        setCompositionRoot(horizontalSplitPanel);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
