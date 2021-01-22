 public class subNodo
 {
        private int elem;
        private subNodo prox;

        public subNodo(int x, subNodo p){
            elem = x;
            prox = p;
        }

        public void setElem2(int x) {
            elem = x;
        }

        public int getElem2() {
            return elem;
        }

        public void setProx2(subNodo p){
            prox = p;
        }

        public subNodo getProx2(){
            return prox;
        }
 }