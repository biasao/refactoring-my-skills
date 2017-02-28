import java.time.Duration;
import java.util.*;

import static java.util.stream.Collectors.*;

public class Winner {

    private int year;
    private String nationality;
    private String name;
    private String team;
    private int lengthKm;
    private Duration winningTime;
    private int stageWins;
    private int daysInYellow;

    public Winner(int year, String nationality, String name, String team, int lengthKm, Duration winningTime, int daysInYellow) {
        this.year = year;
        this.nationality = nationality;
        this.name = name;
        this.team = team;
        this.lengthKm = lengthKm;
        this.winningTime = winningTime;
        this.daysInYellow = daysInYellow;
    }

    public static final List<Winner> tdfWinners = Arrays.asList(
        new Winner(2006, "Spain", "Óscar Pereiro", "Caisse d'Epargne–Illes Balears", 3657, Duration.parse("PT89H40M27S"), 8),
        new Winner(2007, "Spain", "Alberto Contador", "Discovery Channel", 3570, Duration.parse("PT91H00M26S"), 4),
        new Winner(2008, "Spain", "Carlos Sastre", "Team CSC", 3559, Duration.parse("PT87H52M52S"), 5),
        new Winner(2009, "Spain", "Alberto Contador", "Astana", 3459, Duration.parse("PT85H48M35S"), 7),
        new Winner(2010, "Luxembourg", "Andy Schleck", "Team Saxo Bank", 3642, Duration.parse("PT91H59M27S"), 12),
        new Winner(2011, "Australia", "Cadel Evans", "BMC Racing Team", 3430, Duration.parse("PT86H12M22S"), 2),
        new Winner(2012, "Great Britain", "Bradley Wiggins", "Team Sky", 3496, Duration.parse("PT87H34M47S"), 14),
        new Winner(2013, "Great Britain", "Chris Froome", "Team Sky", 3404, Duration.parse("PT83H56M20S"), 14),
        new Winner(2014, "Italy", "Vincenzo Nibali", "Astana", 3661, Duration.parse("PT89H59M06S"), 19),
        new Winner(2015, "Great Britain", "Chris Froome", "Team Sky", 3360, Duration.parse("PT84H46M14S"), 16),
        new Winner(2016, "Great Britain", "Chris Froome", "Team Sky", 3529, Duration.parse("PT89H04M48S"), 14)
    );

    public static void main(String[] args) {
        // Filter and Map -
        List<String> winnersOfToursLessThan3500km = tdfWinners
                                                        .stream()
                                                        .filter(d -> d.getLengthKm() < 3500) // Separate out Tours less than 3500km
                                                        .map(Winner::getName) // Get names of winners
                                                        .collect(toList()); // Converts from stream to list
        System.out.println("Winners of Tours Less than 3500km - " + winnersOfToursLessThan3500km);

        List<String> winnersOfToursGreaterThan3500km = tdfWinners
                                                            .stream()
                                                            .filter(d -> d.getLengthKm() >= 3500)
                                                            .map(Winner::getName)
                                                            .collect(toList());
        System.out.println("Winners of Tours Greater than 3500km - " + winnersOfToursGreaterThan3500km);

        // limit -
        List<Winner> winnerObjectsOfToursLessThan3500kmLimit2 = tdfWinners
                                                                    .stream()
                                                                    .filter(d -> d.getLengthKm() < 3500)
                                                                    .limit(2)
                                                                    .collect(toList());
        System.out.println("winnerObjectsOfToursLessThan3500kmLimit2 " + winnerObjectsOfToursLessThan3500kmLimit2);

        List<String> firstTwoWinnersOfToursLessThan3500km = winnerObjectsOfToursLessThan3500kmLimit2
                                                                .stream()
                                                                .map(Winner::getName)
                                                                .limit(2)
                                                                .collect(toList());
        System.out.println("firstTwoWinnersOfToursLessThan3500km - " + firstTwoWinnersOfToursLessThan3500km);

        // filter by distinct
        List<String> distinctTDFWinners = tdfWinners
                                                .stream()
                                                .map(Winner::getName)
                                                .distinct()
                                                .collect(toList());
        System.out.println("distinctTDFWinners - " + distinctTDFWinners);

        long numberOfDistinctWinners = tdfWinners
                                            .stream()
                                            .map(Winner::getName)
                                            .distinct()
                                            .count();
        System.out.println("numberOfDistinctWinners - " + numberOfDistinctWinners);

        // skip records
        List<Winner> skipEveryOtherTDFWinner = tdfWinners
                                                    .stream()
                                                    .skip(2)
                                                    .collect(toList());
        System.out.println("skipEveryOtherTDFWinner - " + skipEveryOtherTDFWinner);

        List<String> mapWinnerYearNameToList = tdfWinners
                                                    .stream()
                                                    .map(w -> w.getYear() + " - " + w.getName())
                                                    .collect(toList());
        System.out.println("mapWinnerYearNameToList - " + mapWinnerYearNameToList);

        List<Integer> mapWinnerNameLengthToList = tdfWinners
                                                        .stream()
                                                        .map(Winner::getName)
                                                        .map(String::length)
                                                        .collect(toList());
        System.out.println("mapWinnerNameLengthToList - " + mapWinnerNameLengthToList);

        // matching - allMatch, noneMatch
        Optional<Winner> winner2012 = tdfWinners.stream().filter(w -> w.getName().contains("Wiggins")).findAny();
        System.out.println("winner2012 - " + winner2012.get());

        Optional<Integer> winnerYear2014 = tdfWinners.stream().filter(w -> w.getYear() == 2014).map(Winner::getYear).findFirst();
        System.out.println("winnerYear2014 - " + winnerYear2014.get());

        // reducing - 0 --> initial value
        int totalDistance = tdfWinners.stream().map(Winner::getLengthKm).reduce(0, Integer::sum);
        System.out.println(String.format("totalDistance - %d", totalDistance));

        Optional<Integer> shortestDistanceInAYear = tdfWinners.stream().map(Winner::getLengthKm).reduce(Integer::min);
        System.out.println(String.format("shortestDistanceInAYear - %d", shortestDistanceInAYear.get()));

        Optional<Integer> longestDistanceInAYear = tdfWinners.stream().map(Winner::getLengthKm).reduce(Integer::max);
        System.out.println(String.format("longestDistanceInAYear - %d", longestDistanceInAYear.get()));

        Optional<Winner> fastestWinner = tdfWinners.stream().min(Comparator.comparingDouble(Winner::getAveSpeed));
        System.out.println(String.format("fastestWinner - %s", fastestWinner.get()));

        // shorthand
        OptionalDouble fastestAverageSpeed = tdfWinners.stream().mapToDouble(Winner::getAveSpeed).max();
        System.out.println(String.format("fastestAverageSpeed - %f", fastestAverageSpeed.getAsDouble()));

        // groupingby - make a map whose keys are names
        Map<String, List<Winner>> namesVsWinner = tdfWinners.stream().collect(groupingBy(Winner::getName));
        System.out.println("namesVsWinner - " + namesVsWinner);

        // join strings
        String allTDFWinnersTeamsCSV = tdfWinners.stream().map(Winner::getTeam).collect(joining(", "));
        System.out.println(String.format("allTDFWinnersTeamsCSV - %s", allTDFWinnersTeamsCSV));

        // grouping
        Map<String, List<Winner>> winnersByNationality = tdfWinners.stream().collect(groupingBy(Winner::getNationality));
        System.out.println("winnersByNationality - " + winnersByNationality);

        Map<String, Long> winnersByNationalityCount = tdfWinners.stream().collect(groupingBy(Winner::getNationality, counting()));
        System.out.println("winnersByNationalityCount - " + winnersByNationalityCount);

        Map<String, Integer> winnersByNationalitySummingLength = tdfWinners.stream().collect(groupingBy(Winner::getNationality, summingInt(Winner::getLengthKm)));
        System.out.println("winnersByNationalitySummingLength - " + winnersByNationalitySummingLength);
    }

    public double getAveSpeed() {
        return (getLengthKm() / (getWinningTime().getSeconds() / 3600) );
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getLengthKm() {
        return lengthKm;
    }

    public void setLengthKm(int lengthKm) {
        this.lengthKm = lengthKm;
    }

    public Duration getWinningTime() {
        return winningTime;
    }

    public void setWinningTime(Duration winningTime) {
        this.winningTime = winningTime;
    }

    public int getStageWins() {
        return stageWins;
    }

    public void setStageWins(int stageWins) {
        this.stageWins = stageWins;
    }

    public int getDaysInYellow() {
        return daysInYellow;
    }

    public void setDaysInYellow(int daysInYellow) {
        this.daysInYellow = daysInYellow;
    }

    @Override
    public String toString() {
        return name;
    }

}
