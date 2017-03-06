import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;

import static java.util.stream.Collectors.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        Solution s = new Solution();
        String S = lines.stream().collect(joining("\n"));
        System.out.println(s.solution(S));
    }

    // Required codility method.
    public String solution(String S) {
        // TODO
        // DONE 1. Split single input string in multiple strings.
        // DONE 2. Transform input from String to Photo objects.
        // DONE 2. Group by city, and sort each group by date/time.
        // DONE 3. Assign a unique sequential number to each file on the group.
        //      - All sequential number should have the same number of digits.
        //      - i.e. if the last number is 10, all numbers should be 00, 01, 02, etc.
        // DONE 4. Implement toString() using the format "City" + "Sequential Number" + ".Extension".
        // DONE 5. Return string with photo new name in the same order as the input.

        String[] photosAsStrings = S.split("\n");
        Map<String, List<Photo>> photos = Arrays
                                            .stream(photosAsStrings)
                                            .map(PhotoFactory::create)
                                            .collect(groupingBy(Photo::getCity));
        photos.forEach((entry, value) -> Collections.sort(value));
        photos.forEach((entry, photoList) -> {
                                int size = photoList.size();
                                int sizeAsString = String.valueOf(size).length();
                                IntStream.range(0, size).forEach(i -> {
                                    int sequentialNumber = i + 1;
                                    String sequentialNumberAsString = String.format("%0" + sizeAsString + "d", sequentialNumber);
                                    photoList.get(i).sequentialNumber = sequentialNumberAsString;
                                });
                            });

        Map<String, Photo> flattenedPhotos = photos
                                    .values()
                                    .stream()
                                    .flatMap(List::stream)
                                    .collect(toMap(v -> v.getOriginalName(), Function.identity()));

        return Arrays
                .stream(photosAsStrings)
                .map(p -> flattenedPhotos.get(p))
                .map(Photo::toString)
                .collect(joining("\n"));
    }

    static class Photo implements Comparable<Photo> {
        String originalName;
        String city;
        String extension;
        Date dateTime;
        String sequentialNumber;

        Photo(String originalName, String city, String extension, Date dateTime) {
            this.originalName = originalName;
            this.city = city;
            this.extension = extension;
            this.dateTime = dateTime;
        }

        public String getCity() {
            return city;
        }

        public String getOriginalName() {
            return originalName;
        }

        @Override
        public int compareTo(Photo other) {
            return dateTime.compareTo(other.dateTime);
        }

        @Override
        public String toString() {
            return String.format("%s%s.%s", city, sequentialNumber, extension);
        }
    }

    static class PhotoFactory {
        static Photo create(String originalName) {
            String[] data = originalName.split(",");
            String city = data[1].trim();
            String extension = data[0].substring(data[0].lastIndexOf(".") + 1).trim();
            Date dateTime = parseDateTime(data[2].trim());

            return new Photo(originalName, city, extension, dateTime);
        }

        private static Date parseDateTime(String dateTime) {
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return formatter.parse(dateTime);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
