# Game.java
1. 60 FPS 遊戲迴圈 (Game Loop & Game Timer)
run() 裡面利用 System.nanoTime() 計算 delta 時間差。
用Nano Seconds的時間累加器 delta 來控制更新頻率（timePerTick = 1000000000 / 60），確保不論電腦效能快慢，遊戲的邏輯（tick()）與畫面渲染（render()）都能穩定維持在 60 FPS。

2. 畫面緩衝優化 (Buffering & Graphics2D)
render() 裡面的 display.getCanvas().createBufferStrategy(3);
運用 Buffering解決 2D 遊戲畫面會出現的閃爍與撕裂問題，確保繪圖先在背景記憶體繪製完成才一次顯示（bs.show()）。

3. 多執行緒與生命週期控制 (Multithreading & Thread Lifecycle)
採用 Runnable 介面，將遊戲主迴圈放在獨立的背景執行緒運作，避免 UI 介面卡死；並透過 synchronized 搭配 running flag 控制生命週期，配合 thread.join() 確保程式關閉時執行緒能安全關閉

4. 設計模式：狀態模式 (State Pattern)
State.getState().tick() 與 State.getState().render(g):
透過多型讓 Game 不需要管現在是選單、說明頁面還是遊戲中，統一由當前 State 物件去執行各自的 tick() 與 render()，實現模組化 Decoupling。

# Entity
把玩家、怪物（creature/）跟靜態物件（staticc/ 如地板、障礙物）共同的屬性（血量 health、座標 x, y、碰撞盒 bound）抽出來做成 Entity 抽象類別，並訂立tick()、render()、die() 規範，可方便利用EntityManager維護一個 ArrayList和迴圈，更新與繪製場景上的所有東西，而不需要針對 Player 或 Enemy 分開做管理與維護。
碰撞機制:
利用 Java 的 java.awt.Rectangle 實作了碰撞偵測算法。從getCollisionBound 傳入 xOffset, yOffset 預測下一幀移動後的預估位置，如果預測位置與別的 Entity 矩形相交（intersects），就代表會撞到。若物體有血量，當扣血至 health <= 0 時，將 active 改為 false 並觸發抽象方法 die()（交由子類別決定死掉是噴經驗值、放死亡動畫還是消失）搭配 EntityManager（另一個檔案）定期清理 active == false 的物件，避免無效的 Entity 佔用記憶體。

# State
把每一個場景拆成獨立的 Class：GameState（遊玩中）、MenuState（主選單）、HelpState（說明頁）、MapState（地圖選擇），這樣主迴圈 Game.java 只需要呼叫 State.getState().tick()，就能根據當前切換到的狀態去跑對應的邏輯，再用 public static State currentState 管理全域當前的狀態，使得新增一個新頁面完全不需要動到原本的程式架構。

# Handler.java
透過 Handler 作為統一的管道，傳遞 game、world、player 與輸入控制（KeyManager/MouseManager）。

