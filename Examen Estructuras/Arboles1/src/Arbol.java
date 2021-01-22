import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class Arbol
{
        private Nodo raiz;

        public Arbol() {
           raiz = null;
        }
        private boolean esHoja(Nodo pr) {
            return pr.getHI() == null && pr.getHD() == null;
        }     

        public void insertar(int x)
        {
            Nodo q = new Nodo(x);
            if (raiz == null){
                raiz = q;
                return;
            }
            Nodo pr=raiz; 
            Nodo ant=null;
            while (pr != null){
                ant=pr;
                if (x < pr.getElem())
                    pr = pr.getHI();
                else
                    if (x > pr.getElem())
                       pr = pr.getHD();
                    else
                        return ;
            }
            if (x < ant.getElem())
                ant.setHI(q);
            else
                ant.setHD(q);
        }
        
        private Nodo insertarRec(Nodo pr, int x)
        {
            if (pr == null) {
                Nodo q= new Nodo(x);
                return q;
            }

            if(x < pr.getElem())
                pr.setHI(insertarRec(pr.getHI(),x));
            else
                pr.setHD(insertarRec(pr.getHD(),x));

            return pr;
        }

        public void insertarR(int x) {
            raiz=insertarRec(raiz, x);
        }
        
        
         public void eliminarR(int x)
        {
            raiz=eliminarR(raiz,x);
        }
        
        //nfun
        public Nodo eliminarR(Nodo p, int x)
        {
            if (p == null)
                return null;
            
            if (x < p.getElem())
               p.setHI(eliminarR(p.getHI(),x));
            else
              if (x > p.getElem())
                 p.setHD(eliminarR(p.getHD(),x));
              else
                 p=eliminarR(p,x);

            return p;
        }

        private void preOrden(Nodo pr,JTextArea rt)
        {
            if (pr != null) {
                rt.append( String.valueOf(pr.getElem() + "  ") );
                preOrden(pr.getHI(),rt);
                preOrden(pr.getHD(),rt);
            }
        }

        public void preOrden(JTextArea rt) {
            rt.setText("");
            preOrden(raiz,rt);
        }

        private void InOrden(Nodo pr, JTextArea rt)
        {
            if (pr != null)  {
                InOrden(pr.getHI(),rt);
                rt.append(String.valueOf(pr.getElem() + "  "));
                InOrden(pr.getHD(),rt);
            }
        }

        public void InOrden(JTextArea rt)
        {
            rt.setText("");
            InOrden(raiz,rt);
        }

        private void PostOrden(Nodo pr, JTextArea rt)
        {
            if (pr != null)
            {
                PostOrden(pr.getHI(),rt);
                PostOrden(pr.getHD(),rt);
                rt.append(String.valueOf(pr.getElem() + "  "));
            }
        }

        public void PostOrden(JTextArea rt)
        {
           rt.setText("");
           PostOrden(raiz,rt);
        }

        private int suma(Nodo pr)
        {
            if (pr == null)
                return 0;
            else
                if (esHoja(pr))  // no es necesario
                    return pr.getElem();
                else
                {
                    int hi = suma(pr.getHI());
                    int hd = suma(pr.getHD());

                    return hi + hd + pr.getElem();
                }
        }

        public int suma() {
            return suma(raiz);
        }

        public Nodo encontrarNodo(Nodo pr, int x){
            if(pr == null)
                return null;
            else{
                if(pr.getElem() == x)
                    return pr;
                Nodo subArbolIzq = encontrarNodo(pr.getHI(),x);
                Nodo subArbolDer = encontrarNodo(pr.getHD(),x);
                if(subArbolIzq != null)
                    return subArbolIzq;
                return subArbolDer;
            }
        }
        
        public String imprimirHijos(int x){
            Nodo encontrado = encontrarNodo(raiz, x);
            String mensaje = "";
            if(encontrado != null) {
                if(encontrado.getHI() != null)
                    mensaje = "HI: " + String.valueOf(encontrado.getHI().getElem() + " ");
                if(encontrado.getHD() != null)
                    mensaje += "HD: " + String.valueOf(encontrado.getHD().getElem());
                if(mensaje.equals(""))
                    return "Es una hoja";
            } 
            else
                mensaje = "No se encontro el nodo";
            return mensaje;
        }
        
  }//end class


        