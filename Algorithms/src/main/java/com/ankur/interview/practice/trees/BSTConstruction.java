package com.ankur.interview.practice.trees;

public class BSTConstruction {
    public static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST currentNode = this;
            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            return removeInternal(value, null);
        }

        private BST removeInternal(int value, BST parentNode) {
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if (currentNode.left != null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinValue();
                        currentNode.right.removeInternal(currentNode.value, currentNode);
                    } else if (parentNode == null) {
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            currentNode.value = 0;
                        }
                    } else if (parentNode.left == currentNode) {
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    } else if (parentNode.right == currentNode) {
                        parentNode.right = currentNode.right != null ? currentNode.right : currentNode.left;
                    }
                    break;
                }
            }
            return this;
        }

        private int getMinValue() {
            BST curr = this;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr.value;
        }

        public BST createFromSortedArray(int[] array) {
            if (array.length == 0)
                return null;
            return createFromArray(array, 0, array.length - 1);
        }

        private BST createFromArray(int[] array, int low, int high) {
            int mid = low + (high - low) / 2;
            if (low > high) return null;
            BST node = new BST(array[mid]);
            node.left = createFromArray(array, low, mid);
            node.right = createFromArray(array, mid + 1, high);
            return node;
        }

        public boolean validateBST(BST root) {
            return validate(root, null, null);
        }

        private boolean validate(BST root, Integer min, Integer max) {
            if (root == null) {
                return true;
            } else if (min != null && root.value < min || max != null && root.value > max) {
                return false;
            } else {
                return validate(root.left, min, root.value) && validate(root.right, root.value, max);
            }
        }
    }
}

