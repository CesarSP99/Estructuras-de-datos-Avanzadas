
 public class Nodo
 {
        private subLista  elem;
        private Nodo prox;

        public Nodo(){
            prox = null;
        }

        public Nodo(subLista x, Nodo p){
            this.elem = x;
            this.prox = p;
        }

        public void setElem(subLista x) {
            elem = x;
        }

        public subLista getElem() {
            return elem;
        }

        public void setProx(Nodo p){
            prox = p;
        }

        public Nodo getProx(){
            return prox;
        }
 }