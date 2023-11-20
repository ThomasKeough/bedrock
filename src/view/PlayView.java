package view;

import interface_adapters.PlayViewModel;
import interface_adapters.ViewManagerModel;

public class PlayView {
    public final String viewName = "Play Menu";
    private final PlayViewModel playViewModel;
    private ViewManagerModel viewManagerModel;

    public PlayView(PlayViewModel playViewModel, ViewManagerModel viewManagerModel) {
        this.playViewModel = playViewModel;
        this.viewManagerModel = viewManagerModel;

        // TODO: Implement PayView
    }
}
