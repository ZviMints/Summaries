import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.scaladsl.{Broadcast, Flow, GraphDSL, Merge, Partition, RunnableGraph, Sink, Source}
import akka.stream.{ActorMaterializer, ClosedShape}


object ParitionAndMerge extends App {

  val source = Source(1 to 10)
  val sink = Sink.foreach(println)


  val g = RunnableGraph.fromGraph(GraphDSL.create() { implicit builder: GraphDSL.Builder[NotUsed] =>
    import GraphDSL.Implicits._

    val merge = builder.add(Merge[Int](2))
    val partition = builder.add(Partition[Int](2, element => if (element % 2 == 0) 0 else 1))

    val fEven = Flow[Int].map(ele => { println(s"fEven = $ele"); ele })
    val fOdd = Flow[Int].map(ele => { println(s"fOdd = $ele"); ele })


    source ~> partition.in
              partition.out(0) ~> fEven ~> merge
              partition.out(1) ~> fOdd  ~> merge
                                           merge ~> sink
    ClosedShape
  })
  implicit val system = ActorSystem("MyActorSystem") //  heavy data stracture that allocate some threads under the hood
  implicit val materializer = ActorMaterializer // enable akka code to run
  g.run()
}
