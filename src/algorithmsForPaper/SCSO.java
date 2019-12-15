package algorithmsForPaper;

import static java.lang.Math.*;
//粒子的状态类
class ParticlesState
{
    public double x;
    public double f;//适应度，即求解函数值

    ParticlesState(double x)
    {
        this.x = x;
    }
}
public class SCSO {
    int n;                        //粒子数量
    ParticlesState[] p;            //粒子数组
    ParticlesState[] v;            //速度数组
    ParticlesState[] pbest;        //粒子最优解
    ParticlesState gbest;        //全局最优解
    int LB;              //粒子下边界
    int UB;               //粒子上边界

    public static void main(String[] args) {
        System.out.println("**********************SCSO算法实现**********************");

        SCSO e = new SCSO(); //实例化粒子群算法类
        e.init(); //对该类进行初始化
        e.SCSO(200); //调用粒子群算法函数
    }

    //适应函数
    public void fitnessFunction() {
        for (int i = 0; i < n; i++) {
            /*下面是自定义的目标函数*/
            p[i].f = (int) (2 * pow(p[i].x, 4.0) +
                    4 * pow(p[i].x, 3.0) -
                    6 * pow(p[i].x, 2.0) +
                    15 * (p[i].x - 12.0));
        }
    }

    //初始化
    public void init() {
        n = 1000;
        p = new ParticlesState[n];
        v = new ParticlesState[n];
        pbest = new ParticlesState[n];
        gbest = new ParticlesState(0.0);
        LB = -100;
        UB = 100;

        for (int i = 0; i < n; i++) {
            p[i] = new ParticlesState(Math.random());//Math.random()的返回值为：[0.0, 1.0)
            p[i].f = 0.0;//将粒子最初适应度值均取随机值（0，1）
            v[i] = new ParticlesState(Math.random());//Math.random()的返回值为：[0.0, 1.0)
        }

        //初始化粒子与集群的最优值
        gbest.f = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            pbest[i] = p[i];
            if (p[i].f > gbest.f) {
                gbest = p[i];
            }
        }
        System.out.println("初始最优值：" + gbest.x + " " + gbest.f);
    }

    //SCSO算法	max -- 最大迭代次数
    public void SCSO(int max) {
        System.out.println("迭代过程：");
        for (int i = 0; i < max; i++) {
            /*每一次迭代更新1000个粒子的状态，并求其相应的个体极值和全体极值*/
            for (int j = 0; j < n; j++) {
                //更新粒子速度
                double r = Math.random();
                double v = 0.0; //v表示粒子更新速度
                if (r < 0.5) {
                    v = p[i].f + sin(2 * PI * r) * (pbest[i].f - p[i].f);
                } else {
                    v = p[i].f + cos(2 * PI * r) * (pbest[i].f - p[i].f);
                }

                /* 将粒子更新速度限定在一定范围之内 */
                this.v[j] = new ParticlesState(v);//将最新计算的速度添加到速度数组中去

                //更新粒子的位置
                p[i].x = p[i].x + this.v[j].x;

                if (p[i].x < LB || p[i].x > UB) {
                    //MATLAB中rand产生0-1的均匀随机数
                    p[i].x = Math.random() * (UB - LB) + LB;
                }
            }
            /*粒子位置每更新一次，便重新计算一次粒子适应度值*/
            fitnessFunction();

            //更新个体极值和群体极值
            for (int j = 0; j < n; j++) {
                // 1.将每个粒子的适应度值和当前个体极值作比较，确定新的个体极值；
                if (p[i].f > pbest[i].f) {
                    pbest[i] = p[i];
                }
 /*               最初代码：
                if(p[i].f > gbest.f) {
                    gbest = p[i];
                }
                */
                // 2.将每个个体极值和群体极值作比较，确定新的全体极值
                if (pbest[i].f > gbest.f) {
                    gbest = pbest[i];
                }


            }
            System.out.println("===第" + i + "次迭代结果===\n" + gbest.x + " " + gbest.f);
        }
    }
}