/*
        粒子群算法是计算算法的一种，1995年由Eberhart 博士和kennedy 博士提出，源于对鸟群捕食的行为研究 。
        该算法利用群体中的个体对信息的共享使整个群体的运动在问题求解空间中产生从无序到有序的演化过程，从而获得最优解。
        试想一下，如果一群鸟在一片区域中寻找食物，所有的鸟都不知道食物在什么地方，但是每一只鸟都知道自己距离食物有多远，
        也知道这一群鸟中离食物最近的鸟在什么位置，这样每一只鸟都可以改变当前自己的移动方向，逐渐向离食物最近的鸟所在位置靠近，
        这样通过不断的搜寻，就能找到食物。

        本博客地址：https://blog.csdn.net/qq_27124771/article/details/80945337
 */


package algorithmsForPaper;
public class PSO {

    int n;						//粒子数量
    ParticleState[] ps;			//粒子数组
    ParticleState[] pv;			//速度数组
    ParticleState[] pbest_p;		//粒子最优解
    ParticleState gbest_p;		//全局最优解
    double vmax;				//最大速度
    int c1,c2;					//学习参数

    public static void main(String[] args) {
        PSO e = new PSO(); //实例化粒子群算法类
        e.init(); //对该类进行初始化
        e.PSO(200); //调用粒子群算法函数
    }

    //适应函数
    public void fitnessFunction() {
        for(int i = 0; i<n; i++) {
            ps[i].f = ps[i].x* ps[i].x* ps[i].x + 3* ps[i].x* ps[i].y* ps[i].y - 15* ps[i].x -12* ps[i].y; //通过目标函数计算粒子适应度值
        }
    }

    //初始化
    public void init() {
        n = 1000;
        ps = new ParticleState[n];
        pv = new ParticleState[n];
        pbest_p = new ParticleState[n];
        gbest_p = new ParticleState(0.0, 0.0);
        c1=c2=3;
        vmax = 0.1;

        for(int i=0;i<n;i++) {
            ps[i]=new ParticleState(Math.random(),Math.random());//Math.random()的返回值为：[0.0, 1.0)
            pv[i]=new ParticleState(Math.random()*vmax,Math.random()*vmax);
        }

        fitnessFunction();

        //初始化粒子与集群的最优值
        gbest_p.f = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            pbest_p[i]= ps[i];
            if(ps[i].f > gbest_p.f) {
                gbest_p = ps[i];
            }
        }
        System.out.println("初始最优值：" + gbest_p.x+" "+ gbest_p.y+" "+" "+ gbest_p.f);
    }

    //粒子群算法	max -- 最大迭代次数
    public void PSO(int max) {
        System.out.println("迭代过程：");
        for(int i=0;i<max;i++) {
            double w = 0.3;//惯性权重

            /*每一次迭代更新1000个粒子的状态，并求其相应的个体极值和全体极值*/
            for(int j=0;j<n;j++) {
                //更新粒子速度
                double vx=w* pv[j].x+c1*Math.random()*(pbest_p[j].x- ps[j].x)+c2*Math.random()*(gbest_p.x- ps[j].x);
                double vy=w* pv[j].y+c1*Math.random()*(pbest_p[j].y- ps[j].y)+c2*Math.random()*(gbest_p.y- ps[j].y);

               /* 将粒子更新速度限定在一定范围之内 */
                if (vx>vmax) vx=vmax;
                if (vy>vmax) vy=vmax;

                pv[j] = new ParticleState(vx,vy);//将最新计算的速度添加到速度数组中去

                //更新粒子的位置
                ps[j].x += pv[j].x;
                ps[j].y += pv[j].y;
            }

            /*粒子位置每更新一次，便重新计算一次粒子适应度值*/
            fitnessFunction();

            //更新个体极值和群体极值
            for(int j=0;j<n;j++) {
                // 1.将每个粒子的适应度值和当前个体极值作比较，确定新的个体极值；
                if(ps[i].f > pbest_p[i].f) {
                    pbest_p[i] = ps[i];
                }
 /*               最初代码：
                if(p[i].f > gbest.f) {
                    gbest = p[i];
                }
                */
                // 2.将每个个体极值和群体极值作比较，确定新的全体极值
                if(pbest_p[i].f > gbest_p.f) {
                    gbest_p = pbest_p[i];
                }

            }

            System.out.println("===第"+i+"次迭代结果===\n"+ gbest_p.x+" "+ gbest_p.y+" "+" "+ gbest_p.f);
        }
    }
}

//粒子的状态类
class ParticleState{
    public double x;
    public double y;

    public double f;//适应度，即求解函数值

    ParticleState(double x, double y) {
        this.x = x;
        this.y = y;
    }
}