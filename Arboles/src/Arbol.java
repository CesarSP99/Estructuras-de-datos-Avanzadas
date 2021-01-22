import javax.swing.JTextArea;

class Arbol {

    private Nodo raiz;
    private int numPares = 0;

    public Arbol() {
        raiz = null;
    }

    private boolean esHoja(Nodo pr) {
        return pr.getHI() == null && pr.getHD() == null;
    }

    public void insertar(int x) {
        Nodo q = new Nodo(x);
        if (raiz == null) {
            raiz = q;
            return;
        }
        Nodo pr = raiz;
        Nodo ant = null;
        while (pr != null) {
            ant = pr;
            if (x < pr.getElem()) {
                pr = pr.getHI();
            } else if (x > pr.getElem()) {
                pr = pr.getHD();
            } else {
                return;
            }
        }
        if (x < ant.getElem()) {
            ant.setHI(q);
        } else {
            ant.setHD(q);
        }
    }

    private void preOrden(Nodo pr, JTextArea rt) {
        if (pr != null) {
            rt.append(String.valueOf(pr.getElem() + "  "));
            preOrden(pr.getHI(), rt);
            preOrden(pr.getHD(), rt);
        }
    }

    public void preOrden(JTextArea rt) {
        preOrden(raiz, rt);
    }

    private void InOrden(Nodo pr, JTextArea rt) {
        if (pr != null) {
            InOrden(pr.getHI(), rt);
            rt.append(String.valueOf(pr.getElem() + "  "));
            InOrden(pr.getHD(), rt);
        }
    }

    public void InOrden(JTextArea rt) {
        InOrden(raiz, rt);
    }

    private void PostOrden(Nodo pr, JTextArea rt) {
        if (pr != null) {
            PostOrden(pr.getHI(), rt);
            PostOrden(pr.getHD(), rt);
            rt.append(String.valueOf(pr.getElem() + "  "));
        }
    }

    public void PostOrden(JTextArea rt) {
        PostOrden(raiz, rt);
    }

    private int suma(Nodo pr) {
        if (pr == null) {
            return 0;
        } else {
            if (esHoja(pr)) // no es necesario
            {
                return pr.getElem();
            } else {
                int hi = suma(pr.getHI());
                int hd = suma(pr.getHD());
                return hi + hd + pr.getElem();
            }
        }
    }

    public int suma() {
        return suma(raiz);
    }

    private int sumaDePares(Nodo pr) {
        if (pr == null) {
            return 0;
        } else {
            if (esHoja(pr)) {
                if (pr.getElem() % 2 == 0) {
                    return pr.getElem();
                }
                return 0;
            } else {
                int hi = sumaDePares(pr.getHI());
                int hd = sumaDePares(pr.getHD());
                if (pr.getElem() % 2 == 0) {
                    return hi + hd + pr.getElem();
                } else {
                    return hi + hd;
                }
            }
        }
    }

    public int sumaDePares() {
        return sumaDePares(raiz);
    }

    public void contarPares(Nodo pr) {
        if (pr != null) {
            contarPares(pr.getHI());
            if (pr.getElem() % 2 == 0) {
                numPares++;
            }
            contarPares(pr.getHD());
        }
    }

    public int contarPares() {
        numPares = 0;
        contarPares(raiz);
        return numPares;
    }

    public int contarPares2(Nodo pr) {
        if (pr == null) {
            return 0;
        } else {
            if (esHoja(pr)) {
                if (pr.getElem() % 2 == 0) {
                    return 1;
                }
                return 0;
            } else {
                int hi = contarPares2(pr.getHI());
                int hd = contarPares2(pr.getHD());
                if (pr.getElem() % 2 == 0) {
                    return hi + hd + 1;
                } else {
                    return hi + hd;
                }
            }
        }
    }

    public int contarPares2() {
        return contarPares2(raiz);
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo pr) {
        if (pr == null) {
            return 0;
        } else {
            if (esHoja(pr)) {
                return 1;
            } else {
                int ai = altura(pr.getHI());
                int ad = altura(pr.getHD());
                if (ai > ad) {
                    return ai + 1;
                } else {
                    return ad + 1;
                }
            }
        }
    }

    public int mayor() {
        return mayor(raiz);
    }

    private int mayor(Nodo pr) {
        if (pr == null) {
            return 0;
        } else {
            if (esHoja(pr)) {
                return pr.getElem();
            } else {
                int md = mayor(pr.getHD());
                if (pr.getHD() == null) {
                    return pr.getElem();
                } else {
                    return md;
                }
            }
        }
    }

    private boolean existe(Nodo pr, int x) {
        if (pr == null) {
            return false;
        } else {
            boolean ai = existe(pr.getHI(), x);
            boolean ad = existe(pr.getHD(), x);
            if (ai || ad) {
                return true;
            } else {
                return pr.getElem() == x;
            }
        }
    }

    public boolean existe(int elemento) {
        return existe(raiz, elemento);
    }

    private boolean incompleto(Nodo T) {
        return (T.getHD() != null && T.getHI() == null) || (T.getHD() == null && T.getHI() != null);
    }

    private boolean brother(Nodo p, int x, int y) {
        if (p == null) {
            return false;
        } else if (esHoja(p) || incompleto(p)) {
            return false;
        } else {
            if (brother(p.getHI(), x, y) || brother(p.getHD(), x, y)) {
                return true;
            } else {  //Para la forma como ingrese los hnos
                if (p.getHI().getElem() == x && p.getHD().getElem() == y || p.getHI().getElem() == y && p.getHD().getElem() == x) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean brother(int x, int y) {
        return brother(raiz, x, y);
    }

    private void mostrarPares(Nodo pr, JTextArea rt) {
        if (pr == null) {
            return;
        } else if (esHoja(pr)) {
            if (pr.getElem() % 2 == 0) {
                rt.append(pr.getElem() + " ");
            }
        } else {
            mostrarPares(pr.getHI(), rt);
            mostrarPares(pr.getHD(), rt);
            if (pr.getElem() % 2 == 0) {
                rt.append(pr.getElem() + " ");
            }
        }
    }

    public void mostrarPares(JTextArea jta) {
        mostrarPares(raiz, jta);
    }

    private int cantHojas(Nodo pr) {
        if (pr == null) {
            return 0;
        } else {
            int hi = cantHojas(pr.getHI());
            int hd = cantHojas(pr.getHD());
            if (pr.getHI() == null && pr.getHD() == null) {
                return hi + hd + 1;
            } else {
                return hi + hd;
            }
        }
    }

    public int cantHojas() {
        return cantHojas(raiz);
    }

    private boolean esSuHijo(Nodo pr, int hijo) {
        if (pr == null) {
            return false;
        }
        if (!esHoja(pr)) {
            if (pr.getHD() != null && pr.getHD().getElem() == hijo) {
                return true;
            }
            if (pr.getHI() != null && pr.getHI().getElem() == hijo) {
                return true;
            }

        }
        return false;
    }

    private int retornaAbuelo(Nodo pr, int x) {
        if (pr == null) {
            return 0;
        }
        if (altura(pr) >= 3) {
            if (pr.getHI() != null && esSuHijo(pr.getHI(), x)) {
                return pr.getElem();
            }
            if (pr.getHD() != null && esSuHijo(pr.getHD(), x)) {
                return pr.getElem();
            }
        }
        int ai = retornaAbuelo(pr.getHI(), x);
        int ad = retornaAbuelo(pr.getHD(), x);
        if (ai != 0) {
            return ai;
        } else if (ad != 0) {
            return ad;
        } else {
            return 0;
        }
    }

    public int retornaAbuelo(int x) {
        return retornaAbuelo(raiz, x);
    }

    ///NO TESTEADO
    private int retornaPadre(Nodo pr, int x) {
        if (pr == null) {
            return 0;
        }
        if (altura(pr) >= 2) {
            if (pr.getHI() != null && esSuHijo(pr, x)) {
                return pr.getElem();
            }
            if (pr.getHD() != null && esSuHijo(pr, x)) {
                return pr.getElem();
            }
        }
        int ai = retornaPadre(pr.getHI(), x);
        int ad = retornaPadre(pr.getHD(), x);
        if (ai != 0) {
            return ai;
        } else if (ad != 0) {
            return ad;
        } else {
            return 0;
        }
    }

    public int retornaPadre(int x) {
        return retornaPadre(raiz, x);
    }

    private int retornarHermano(Nodo pr, int x) {
        if (pr == null) {
            return 0;
        }
        else if (esHoja(pr) || incompleto(pr)) {
            return 0;
        } 
        else if (brother(pr, pr.getHI().getElem(), x)) {
            return pr.getHI().getElem();
        }
        else if (brother(pr, pr.getHD().getElem(), x)) {
            return pr.getHD().getElem();
        }
        
        int ai = retornarHermano(pr.getHI(), x);
        int ad = retornarHermano(pr.getHD(), x);
        
        if (ai != 0) {
            return ai;
        } 
        else if (ad != 0) {
            return ad;
        } 
        else {
            return 0;
        }
    }

    public int retornarHermano(int x) {
        return retornarHermano(raiz, x);
    }
    
    public boolean tieneNietos(int x){
        return tieneNietos(raiz, x);
    }
        
    //Revisar
    private boolean tieneNietos(Nodo pr, int x) {
        if(pr == null)
            return false;
        else if(altura(pr) >= 3 && pr.getElem() == x){
            if(pr.getHI() != null || pr.getHD() != null)
                return true;
        }
        
        boolean ai = tieneNietos(pr.getHI(), x);
        boolean ad = tieneNietos(pr.getHD(), x);
        
        return ai || ad;
    }
    
}//end class
