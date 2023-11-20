package app;

import data.CardDAO;
import entities.Card;
import entities.CardFactory;
import entities.CommonCardFactory;
import interface_adapters.MainViewModel;
import interface_adapters.ViewManagerModel;
import interface_adapters.add_to_collection.AddToCollectionViewModel;
import interface_adapters.build_card.BuildCardViewModel;
import interface_adapters.build_deck.BuildDeckViewModel;
import view.MainView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Pokemon");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        MainViewModel mainViewModel = new MainViewModel();
        AddToCollectionViewModel addToCollectionViewModel = new AddToCollectionViewModel();
        BuildDeckViewModel buildDeckViewModel = new BuildDeckViewModel();
        BuildCardViewModel buildCardViewModel = new BuildCardViewModel();

        CardDAO userDataAccessObject;
        try {
            userDataAccessObject = new CardDAO("./cards.csv", new CommonCardFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MainView mainView = new MainView(mainViewModel);
        views.add(mainView, mainView.viewName);

        viewManagerModel.setActiveView(mainView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setSize(600, 600);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}