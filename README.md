# bowling-scoring-engine
### Installing
git clone https://github.com/TonyJulin/bowling-scoring-engine.git

### Running
<i>javac Bowling.java BowlingFrame.java</i>
 
Navigate up to /src folder
  <br>
<i>java -classpath . main.java.Bowling</i>
### TODO
-Better test case coverage. Couldn't get test to work for play function due to Scanner usage. May use Mockito for that in the future<br>
-Simplify and break out methods and reduce duplication for calculating rolls<br>
-Make calculation/scoring methods private to be called by public methods. Made them public in order to test.<br>
-Stretch goal: Make a cooler, more engaging UI and add back-end functionality to multiple games and view scores
