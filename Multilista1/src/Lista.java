
import javax.swing.JOptionPane;

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
       public Nodo Primero()  {
         Nodo p=primero;
         return p;
       }

       public Nodo crearNodo(SubLista x, Nodo p) {
           Nodo q = new Nodo(x, p);
           return q;
       }

       public void insertarPrimero(SubLista x){
           Nodo q = crearNodo(x, primero);
           primero = q;
           cantidad++;
       }


       public void insertarUltimo(SubLista x) {
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
       
     
        public SubLista getSubLista(int pos) {

            Nodo p = primero;
                int k = 1;
                while (k < pos && p!=null){
                    p = p.getProx();
                    k++;
                }
                return p.getListaDeLista();

        }

        public int precioPorPiso(int piso)
        {
            Nodo p=primero;
            int s=0;
            int i=1;
            SubLista LL1=new SubLista();
            LL1=getSubLista(piso);
            SubNodo q=LL1.Primero();
            while(q!=null)
            {
                s=s+LL1.getPRECIO(i);
                q=q.getSubProx();
                i++;
            }
            return s;
        }
        public void InsertarAlFinal(int pos, int cod, int precio){
            if(pos < this.getCant()){
                    Nodo nodo = this.primero;
                    for(int i = 0; i < pos; i++)
                        nodo = nodo.getProx();
                    SubLista subLista = nodo.getListaDeLista();
                    //sublista.InsertarUltimo(pos, cod);
                    SubNodo subNodo = subLista.Primero();
                    while(subNodo.getSubProx() != null)
                        subNodo = subNodo.getSubProx();
                    subNodo.setSubProx(new SubNodo(cod, precio, null));
                    subLista.setCant(subLista.getCant()+1);
            }
            else{
                    JOptionPane.showMessageDialog(null,"Posicion no valida");
            }
	}
        public void InsertarEnPos(int pos, int subPos, int cod, int precio){
            if(pos < this.getCant()){
                Nodo nodo = primero;
                for(int i = 0;i < pos; i++)
                    nodo = nodo.getProx();
                SubLista subLista = nodo.getListaDeLista();
                if(subPos == 1){
                    subLista.insertarPrimero(cod, precio);
                }
                else if(subPos < subLista.getCant()){
                    SubNodo anterior = subLista.Primero();
                    for(int i = 0; i < pos - 1; i++)
                        anterior = anterior.getSubProx();
                    anterior.setSubProx(new SubNodo(cod, precio, anterior.getSubProx()));
                    subLista.setCant(subLista.getCant()+1);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Posicion no valida");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Posicion no valida");
            }
        }
        public void EliminarEnPos(int pos, int subPos, int cod, int precio){
            if(pos < this.getCant()){
                Nodo nodo = primero;
                for(int i = 0;i < pos; i++)
                    nodo = nodo.getProx();
                SubLista subLista = nodo.getListaDeLista();
                if(subPos == 1){
                    subLista.insertarPrimero(cod, precio);
                }
                else if(subPos < subLista.getCant()){
                    SubNodo anterior = subLista.Primero();
                    for(int i = 0; i < pos - 1; i++)
                        anterior = anterior.getSubProx();
                    anterior.setSubProx(new SubNodo(cod, precio, anterior.getSubProx()));
                    subLista.setCant(subLista.getCant()+1);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Posicion no valida");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Posicion no valida");
            }
        }
}//end clase
