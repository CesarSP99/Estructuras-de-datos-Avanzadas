
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class Vector
{
        private Lista[] v;
        private int n;

        public Vector(){
            v = new Lista[100];
            n = 0;
        }

        public void setDim(int d){
            n = d;
        }

        public int getDim() {
            return n;
        }

        public void setElem(Lista x, int pos) {
            v[pos] = x;
        }

        public Lista getElem(int pos)
        {
            return v[pos];
        }

        private boolean  vacia()
        {
            return n == 0;
        }

        private boolean llena()
        {
            return n == 100;
        }

        public void insertar(Lista x, int p)
        {
            if (llena())  {
                JOptionPane.showMessageDialog(null, "Vector lleno..!!!");
                return;
            }

            if (p < 0 || p > n)
            {
                JOptionPane.showMessageDialog(null,"Posición no válida..!!!");
                return;
            }
            else
            {
                int k = n - 1;
                while (k >= p)
                {
                    v[k + 1] = v[k];
                    k = k - 1;
                }
                v[p] = x;
                n=n+1;
            }
        }

        public void insertarPri(Lista x)
        {
            insertar(x, 0);
        }

        public void insertarUlt(Lista x)
        {
            insertar(x, n);
        }

        public void eliminar(int pos)
        {
            if (vacia())
            {
                JOptionPane.showMessageDialog(null, "Vector vacio...!!");
                return;
            }

            int k = pos + 1;
            while (k < n)
            {
                v[k - 1] = v[k];
                k = k + 1;
            }
            n = n - 1;
        }

        public void eliminarPri()
        {
            eliminar(0);
        }

        public void eliminarUlt()
        {
            eliminar(n - 1);
        }
        
        public void sumarSubLista(JTextArea ta){ 
            for(int i = 0;i < n; i++){
                Lista L1 = getElem(i);
                Nodo p = L1.Primero();
                int j=1;
                while(p!=null)
                {
                    subLista SL=p.getElem();
                    subNodo q=SL.Primero2();
                    int acum = 0;               
                    while(q != null)
                    {
                        acum = acum + q.getElem2();
                        q = q.getProx2();
                    }                               
                    ta.append(i + " " + j + " " + acum);  
                    ta.append("\n");                              
                    p = p.getProx();               
                }            
                j++;
            }
        }
        public void mayorDeCadaLista(JTextArea ta){
            for(int i = 0;i < n; i++){
                Lista L1 = getElem(i);
                Nodo p = L1.Primero();
                while(p!=null){
                    subLista SL = p.getElem();
                    subNodo q = SL.Primero2();
                    while(q != null){
                        int mayor = -999;
                        if(q.getElem2() > mayor){
                            mayor = q.getElem2();
                        }
                        q = q.getProx2();
                    }
                    ta.append(mayor);
                    ta.append("\n");
                    p = p.getProx();
                }
            }
        }
              
}//end class
