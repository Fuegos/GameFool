abstract class HandlerSet {
    protected HandlerSet next;

    public HandlerSet(HandlerSet handlerSet) {
        this.next = handlerSet;
    }

    public HandlerSet() {

    }

    public abstract void work(Match match);
}
