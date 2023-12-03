package view;

import interface_adapters.DecksViewModel;
import interface_adapters.ViewManagerModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecksView extends JPanel {
    public final String viewName = "Decks Menu";
    private final DecksViewModel decksViewModel;
    private ViewManagerModel viewManagerModel;
    final JButton back;

    public DecksView(DecksViewModel decksViewModel, ViewManagerModel viewManagerModel) {
        this.decksViewModel = decksViewModel;
        this.viewManagerModel = viewManagerModel;

        back = new JButton(decksViewModel.BACK_BUTTON_LABEL);
        this.add(back);

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            // Set activeView to HubView
                            viewManagerModel.setActiveView("Hub Menu");
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );
    }
}
