import java.util.*;

public class Main {
    
    // Classe que representa a árvore segmentada (Segment Tree)
    static class SegTree {
        
        // Estrutura do nó da Segment Tree
        static class Node {
            long x;

            // Método para unir dois nós da árvore, aqui a operação é uma soma
            static Node join(Node lhs, Node rhs) {
                Node result = new Node();
                result.x = lhs.x + rhs.x;
                return result;
            }

            // Método para atualizar o valor de um nó
            void update(Node rhs) {
                this.x += rhs.x;
            }
        }

        int n; // Tamanho da árvore
        Node[] tree; // Array que representa a árvore segmentada

        // Construtor que inicializa a árvore com um determinado tamanho
        public SegTree(int n) {
            this.n = n;
            this.tree = new Node[n * 4]; // A Segment Tree precisa de até 4 vezes o tamanho do array de entrada
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node();
            }
        }

        // Construtor que inicializa a árvore a partir de um array de nós
        public SegTree(Node[] v) {
            this.n = v.length;
            this.tree = new Node[n * 4];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node();
            }
            build(v, 0, 0, n - 1); // Construir a árvore a partir do array
        }

        // Método para construir a árvore segmentada
        private void build(Node[] v, int no, int l, int r) {
            if (l == r) {
                tree[no] = v[l]; // Se é uma folha, copia o valor do array de entrada
            } else {
                int m = (l + r) / 2; // Calcula o meio do segmento
                build(v, no * 2 + 1, l, m); // Constrói a árvore à esquerda
                build(v, no * 2 + 2, m + 1, r); // Constrói a árvore à direita
                tree[no] = Node.join(tree[no * 2 + 1], tree[no * 2 + 2]); // Junta os resultados
            }
        }

        // Método para obter a soma de um intervalo [a, b]
        private Node get(int no, int l, int r, int a, int b) {
            if (a <= l && r <= b) {
                return tree[no]; // Segmento totalmente dentro do intervalo
            }

            int m = (l + r) / 2;
            if (b <= m) return get(no * 2 + 1, l, m, a, b); // Intervalo à esquerda
            else if (a > m) return get(no * 2 + 2, m + 1, r, a, b); // Intervalo à direita
            
            return Node.join(
                get(no * 2 + 1, l, m, a, b), // Junta os resultados da esquerda
                get(no * 2 + 2, m + 1, r, a, b) // e da direita
            );
        }

        // Método público para obter a soma de um intervalo [a, b]
        public Node get(int a, int b) {
            return get(0, 0, n - 1, a, b);
        }

        // Método para atualizar o valor de um elemento na posição p
        private void upd(int no, int l, int r, int p, Node val) {
            if (l == r) {
                tree[no].update(val); // Se é uma folha, atualiza o valor
                return;
            }
            
            int m = (l + r) / 2;
            if (p <= m) upd(no * 2 + 1, l, m, p, val); // Atualiza à esquerda
            else upd(no * 2 + 2, m + 1, r, p, val); // Atualiza à direita

            tree[no] = Node.join(tree[no * 2 + 1], tree[no * 2 + 2]); // Atualiza o nó atual após a modificação
        }

        // Método público para atualizar o valor de um elemento na posição p
        public void upd(int p, Node val) {
            upd(0, 0, n - 1, p, val);
        }
    }
    
    public static void main(String[] args) {
        // Array inicial com valores
        long[] values = {1, 2, 3, 4, 5};
        
        // Criando um array de Node para passar para o SegTree
        SegTree.Node[] nodes = new SegTree.Node[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new SegTree.Node();
            nodes[i].x = values[i];
        }
        
        // Inicializando a Segment Tree com o array de nodes
        SegTree segTree = new SegTree(nodes);
        
        // Realizando uma consulta na Segment Tree
        // Exemplo: soma do intervalo de índice 1 a 3 (valores 2, 3, 4)
        SegTree.Node result = segTree.get(1, 3);
        System.out.println("Soma do intervalo [1, 3]: " + result.x); // Saída: 9

        // Atualizando o valor no índice 2 (de 3 para 10)
        SegTree.Node newValue = new SegTree.Node();
        newValue.x = 7; // Adicionando 7 ao valor existente, 3+7=10
        segTree.upd(2, newValue);
        
        // Realizando a consulta novamente após a atualização
        result = segTree.get(1, 3);
        System.out.println("Soma do intervalo [1, 3] após atualização: " + result.x); // Saída: 16
    }
}
