public class FactoryCardExotic extends FactoryCard{
    @Override
    public PlayingCard createCard(String type) {
        Cancel cancel = new Cancel(type);
        Adapter adapter = new Adapter(cancel);
        return adapter;
    }
}
