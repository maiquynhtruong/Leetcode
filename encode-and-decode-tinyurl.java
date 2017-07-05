public class Codec {
    HashMap<String, String> urlMap = new HashMap<String, String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hashCode = generateRandomHashCode(longUrl);
        if (urlMap.containsKey(hashCode)) return urlMap.get(hashCode);
        else {
            urlMap.put(hashCode, longUrl);
            return "http://tinyurl.com/" + hashCode;
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl.substring(20));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
