if (head == null || k == 1) {
            return head;
        }
        node<Integer> curr = head, fwd = null, prev = null;
        int count = 0;
        while (count < k && curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
            count++;
        }
        if (fwd != null) {
            head.next = reverse(fwd, k);
        }
        return prev;