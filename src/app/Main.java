package app;

import data.CardDAO;
import data.TradingCardGameDAO;
import data.PlayerDAO;
import entities.*;
import interface_adapters.*;
//import interface_adapters.add_to_collection.AddToCollectionViewModel;
//import interface_adapters.build_card.BuildCardViewModel;
//import interface_adapters.build_deck.BuildDeckViewModel;
import interface_adapters.wonder_trade.WonderTradeController;
import interface_adapters.wonder_trade.WonderTradeViewModel;
import use_cases.wonder_trade.WonderTradeInputBoundary;
import interface_adapters.build_deck.BuildDeckViewModel;
import interface_adapters.delete_deck.DeleteDeckViewModel;
import view.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static Player player;
    public static void main(String[] args) {
        TradingCardGameDAO.fetch_and_write_data();

        if (PlayerDAO.playerDataExists()){
            System.out.println("Existing player data found!");
            player = PlayerDAO.loadPlayer();
        }
        else{
            System.out.println("Welcome New Player!");
            player = PlayerDAO.createExamplePlayer();
            PlayerDAO.savePlayer(player);

        }

        JFrame application = new JFrame("Pokémon");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        MainViewModel mainViewModel = new MainViewModel();
        HubViewModel hubViewModel = new HubViewModel();
        PlayViewModel playViewModel = new PlayViewModel();
        CollectionViewModel collectionViewModel = new CollectionViewModel();
        DecksViewModel decksViewModel = new DecksViewModel();

        DeleteDeckViewModel deleteDeckViewModel = new DeleteDeckViewModel();
        BuildDeckViewModel buildDeckViewModel = new BuildDeckViewModel();

        CardDAO userDataAccessObject;
        try {
            userDataAccessObject = new CardDAO("./cards.csv", new CommonCardFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MainView mainView = new MainView(mainViewModel, viewManagerModel);
        views.add(mainView, mainView.viewName);

        HubView hubView = new HubView(hubViewModel, viewManagerModel);
        views.add(hubView, hubView.viewName);

        PlayView playView = new PlayView(playViewModel, viewManagerModel);
        views.add(playView, playView.viewName);

        CollectionView collectionView = new CollectionView(collectionViewModel, viewManagerModel);
        views.add(collectionView, collectionView.viewName);

        DecksView decksView = DeckUseCaseFactory.create(viewManagerModel, decksViewModel,
                deleteDeckViewModel, buildDeckViewModel);
        views.add(decksView, decksView.viewName);

        BuildDeckView buildDeckView = BuildDeckUseCaseFactory.create(viewManagerModel, buildDeckViewModel);
        views.add(buildDeckView, buildDeckView.viewName);

        viewManagerModel.setActiveView(mainView.viewName);
        viewManagerModel.firePropertyChanged();

        // Title Bar Icon
        try {
            Image pokeballIcon = ImageIO.read(new File("images/pokeball_icon.png"));
            application.setIconImage(pokeballIcon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        application.pack();
        application.setSize(1280, 720);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}