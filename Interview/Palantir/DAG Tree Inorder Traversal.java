public Character find(Node node, int n) {
    Character[] c = new Character[1];
    HashMap<Node, Integer> map = new HashMap<Node, Integer>();
    count(map, node, n, c);
    return c[0];
}

private int count(HashMap<Node, Integer> map, Node node, int n, Character[] c) {
    if (n <= 0) {
        return 0;
    } else if (node == null) {
        return 0;
    } else if (map.containsKey(node)) {
        return map.get(node);
    }

    int count = 1;

    int leftCount = count(node.left, n);
    if (leftCount == -1) {
        return -1;
    } else if ((count += leftCount) == n) {
        c[0] = node.val;
        return -1;
    }

    int rightCount += count(node.right, n - count);
    if (rightCount == -1) {
        return -1;
    } else if ((count += rightCount) == n) {
        c[0] = node.val;
        return -1;
    }

    map.put(node, count);
    return count;
}