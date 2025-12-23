package week8.pccp2;

// https://school.programmers.co.kr/learn/courses/30/lessons/340213
// [PCCP 기출문제] 1번 / 동영상 재생기
class Solution {
    // 모든 입력값들을 통일성있게 "초"로 변환처리 메서드 mm * 60 -> ss
    public int toSecond(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        // 1. 우선 계산하기 편하게 ss로 변환
        int videoLen = toSecond(video_len);
        int playLoc = toSecond(pos);
        int opStart = toSecond(op_start);
        int opEnd = toSecond(op_end);

        // 2. 시작 전 오프닝 체크
        // op_start ≤ 현재 재생 위치 ≤ op_end
        if(playLoc >= opStart && playLoc <= opEnd) playLoc = opEnd;

        for (String cmd : commands){
            if(cmd.equals("prev")) {
                // 10초 전으로 이동, 현재위치가 < 10초 영상의 처음 위치로 이동(0:0)
                playLoc = Math.max(0, playLoc - 10); // 0 미만 방지
            } else if(cmd.equals("next")) {
                // 10초 후로 이동, 동영상이 남은 시간이 < 10초, 영상의 마지막 위치로 이동(동영상 길이와 ==)
                playLoc = Math.min(videoLen, playLoc + 10); // 초과방지
            }

            // 오프닝 건너뛰기
            // 현재 재생 위치가 오프닝 구간(op_start ≤ 현재 재생 위치 ≤ op_end)인 경우 자동으로 오프닝이 끝나는 위치로 이동합니다.
            if(playLoc >= opStart && playLoc <= opEnd) playLoc = opEnd;
        }
        // ss -> mm:ss로 변환
        int mm = playLoc / 60;
        int ss = playLoc % 60;
        return String.format("%02d:%02d", mm, ss); // // 5분 3초 → "05:03"
    }
}
