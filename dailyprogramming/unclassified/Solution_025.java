package unclassified;

import java.util.*;

// programmers 알고리즘 문제 풀이
// 베스트 앨범
// #해시
// https://programmers.co.kr/learn/courses/30/lessons/42579
public class Solution_025 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> res = new ArrayList<>();
        Map<String, Genre> genreMap = new HashMap<>();
        Map<String, List<Music>> songsByGenre = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            if (genreMap.containsKey(genres[i])) {
                Genre g = genreMap.get(genres[i]);
                g.plusCnt(plays[i]);
                genreMap.put(genres[i], g);
            } else {
                genreMap.put(genres[i], new Genre(genres[i], plays[i]));
            }
            if (songsByGenre.containsKey(genres[i])) {
                songsByGenre.get(genres[i]).add(new Music(i, plays[i]));
            } else {
                ArrayList<Music> genre = new ArrayList<>();
                genre.add(new Music(i, plays[i]));
                songsByGenre.put(genres[i], genre);
            }
        }
        List<Genre> genreList = new ArrayList<>();
        for (String g : genreMap.keySet()) {
            genreList.add(genreMap.get(g));
        }
        Collections.sort(genreList);
        for (Genre g : genreList) {
            System.out.println(g.genre + ", " + g.cnt);
        }
        for (int i = 0; i < genreList.size(); i++) {
            List<Music> mList = songsByGenre.get(genreList.get(i).genre);
            if (mList == null) {
            }
            Collections.sort(mList);
            for (int j = 0; j < mList.size() && j < 2; j++) {
                res.add(mList.get(j).musicNo);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    class Genre implements Comparable<Genre> {
        String genre;
        int cnt;

        public Genre(String genre, int cnt) {
            this.genre = genre;
            this.cnt = cnt;
        }

        public void plusCnt(int cnt) {
            this.cnt += cnt;
        }

        @Override
        public int compareTo(Genre o) {
            return Integer.compare(o.cnt, this.cnt);
        }
    }

    class Music implements Comparable<Music> {
        int musicNo;
        int playCnt;

        public Music(int musicNo, int playCnt) {
            this.musicNo = musicNo;
            this.playCnt = playCnt;
        }

        @Override
        public int compareTo(Music o) {
            return (this.playCnt == o.playCnt) ? Integer.compare(this.musicNo, o.musicNo) : Integer.compare(o.playCnt, this.playCnt);
        }
    }
}