package use_cases.build_card;

public interface BuildCardDataAccessInterface {

    boolean existsByID(String id)

    void save(Card card);

}
