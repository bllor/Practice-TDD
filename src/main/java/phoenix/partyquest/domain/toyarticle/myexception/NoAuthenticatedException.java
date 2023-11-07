package phoenix.partyquest.domain.toyarticle.myexception;

public class NoAuthenticatedException  extends ArticleException {

    public static final String MESSAGE = "글 권한X...";

    public NoAuthenticatedException() {
        super(MESSAGE);
    }
    @Override
    public int getStatus() {
        return 403;
    }
}
