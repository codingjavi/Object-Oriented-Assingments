public enum Color {
    PURPLE(0x800080),
    PINK(0xFFC0CB),
    ORANGE(0xFFA500),
    MAGENTA(0xFF00FF);


    private int rgb;

    private Color (int rgb) {
        this.rgb = rgb;
    }

    public String toString() {
        String hex = String.format("0x%06X", rgb);
        return String.format("%8s ( %s ) ", this.name(), hex);
    }
}

