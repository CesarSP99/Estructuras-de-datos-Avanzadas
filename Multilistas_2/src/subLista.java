

 public class subLista
 {
       private subNodo primero;
       private int cantidad;
       
       public subLista(){
            primero = null;
            cantidad = 0;
       }

       public boolean vacia2() {
           return primero == null;
       }

       public void setCant2(int c) {
             cantidad=c;
       }

       public int getCant2() {
            return cantidad;
       }
       public subNodo Primero2()
       {
         return primero;
       }

       public subNodo crearNodo(int x, subNodo p) {
           subNodo q = new subNodo(x,p);
           return q;
       }

       public void insertarPrimero2(int x){
           subNodo q = crearNodo(x, primero);
           primero = q;
           cantidad++;
       }
           public void insertarUltimo2(int x) {
           if (vacia2())
               insertarPrimero2(x);
           else
           {
               subNodo p = primero;
               while (p.getProx2() != null)
                   p = p.getProx2();

               subNodo q = crearNodo(x,null);
               p.setProx2(q);

               cantidad++;
           }
       }



 }//end clase