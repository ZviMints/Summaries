import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.scaladsl.{Broadcast, Flow, GraphDSL, Merge, RunnableGraph, Sink, Source, Zip}
import akka.stream.{ActorMaterializer, ClosedShape}


object BroadcastAndZip extends App {

  val source = Source(1 to 10)
  val sink = Sink.foreach(println)


  val g = RunnableGraph.fromGraph(GraphDSL.create() { implicit builder: GraphDSL.Builder[NotUsed] =>
    import GraphDSL.Implicits._

    val broadcast = builder.add(Broadcast[Int](2))
    val zip = builder.add(Zip[Int, Int])

    val f2 = Flow[Int].map(ele => { println(s"Flow2 = $ele"); ele })
    val f4 = Flow[Int].map(ele => { println(s"Flow4 = $ele"); ele })

    source ~> broadcast
              broadcast.out(0) ~> f2 ~> zip.in0
              broadcast.out(1) ~> f4 ~> zip.in1
                                        zip.out ~> sink
    ClosedShape
  })
  implicit val system = ActorSystem("MyActorSystem") //  heavy data stracture that allocate some threads under the hood
  implicit val materializer = ActorMaterializer // enable akka code to run
  g.run()
}
