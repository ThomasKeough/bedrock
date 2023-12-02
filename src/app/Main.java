import data.CardDAO;
import data.TradingCardGameDAO;
import entities.Collection;
import entities.CommonCardFactory;
import entities.CommonCollection;
import interface_adapters.*;
//import interface_adapters.add_to_collection.AddToCollectionViewModel;
//import interface_adapters.build_card.BuildCardViewModel;
//import interface_adapters.build_deck.BuildDeckViewModel;
import view.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
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
        HubViewModel hubViewModel = new HubViewModel();
        PlayViewModel playViewModel = new PlayViewModel();
        CollectionViewModel collectionViewModel = new CollectionViewModel();
        DecksViewModel decksViewModel = new DecksViewModel();

        TradingCardGameDAO dao = new TradingCardGameDAO();
        dao.fetch_and_write_data();

        CommonCollection collection = new CommonCollection();
        collection.initializeCollection();
      
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

        CollectionView collectionView = new CollectionView(collectionViewModel);
        views.add(collectionView, collectionView.viewName);

        DecksView decksView = new DecksView(decksViewModel);
        views.add(decksView, decksView.viewName);

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