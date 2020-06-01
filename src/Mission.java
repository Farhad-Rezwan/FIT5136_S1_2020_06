public class Mission {
    private SelectionCriteria selectionCriteria;

    public Mission() {
      selectionCriteria = new SelectionCriteria();
    }

    public SelectionCriteria getSelectionCriteria() {
        return selectionCriteria;
    }

    public void setSelectionCriteria(SelectionCriteria selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
    }
}
