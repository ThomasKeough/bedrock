package entities;

import java.util.HashMap;

public interface CardFactory {

    Card create(String id, String name);
}
