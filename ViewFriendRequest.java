public class ViewFriendRequest extends ItensForMenu implements Command{
    Relacionamentos relation = new Relacionamentos();

    public ViewFriendRequest(String log) {
        this.login = log;
    }

    @Override
    public void execute(ItensForMenu ifm) {
        relation.solicitacoes(this.login, ifm.usersList);
    }
}