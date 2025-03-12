public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> privileged = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = reader.readLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            if (command.equals("+")) {
                int goblinNumber = Integer.parseInt(parts[1]);
                queue.addLast(goblinNumber);
            } else if (command.equals("*")) {
                int goblinNumber = Integer.parseInt(parts[1]);
                int midIndex = (queue.size() + privileged.size()) / 2;
                privileged.add(midIndex, goblinNumber);
            } else if (command.equals("-")) {
                if (!privileged.isEmpty()) {
                    writer.write(privileged.remove(0) + "\n");
                } else {
                    writer.write(queue.pollFirst() + "\n");
                }
            }
        }

        reader.close();
        writer.close();
    }
}
