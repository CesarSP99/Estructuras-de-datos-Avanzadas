
 class Lista
 {
        private Nodo primero;
        private int cantidad;
        
       public Lista(){
            primero = null;
            cantidad = 0;
       }

       public boolean vacia() {
           return primero == null;
       }

       public void setCant(int c) {
             cantidad=c;
       }

       public int getCant() {
            return cantidad;
       }
       public Nodo Primero()
       {
         return primero;
       }

       public Nodo crearNodo(subLista x, Nodo p) {
           Nodo q = new Nodo(x,p);
           return q;
       }

       public void insertarPrimero(subLista x){
           Nodo q = crearNodo(x, primero);
           primero = q;
           cantidad++;
       }

       public void insertarUltimo(subLista x) {
           if (vacia())
               insertarPrimero(x);
           else
           {
               Nodo p = primero;
               while (p.getProx() != null)
                   p = p.getProx();

               Nodo q = crearNodo(x,null);
               p.setProx(q);

               cantidad++;
           }
       }

        public subLista getElemento(int pos)
        {
            Nodo p = primero;
                int k = 1;
                while (k < pos && p!=null){
                    p = p.getProx();
                    k++;
                }
                return  p.getElem();

        }

    }//end clase