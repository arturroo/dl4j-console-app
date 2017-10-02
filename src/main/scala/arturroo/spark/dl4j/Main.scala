package arturroo.spark.dl4j.vgg16

import java.io.File
import org.datavec.image.loader.NativeImageLoader
import org.deeplearning4j.nn.graph.ComputationGraph
import org.deeplearning4j.nn.modelimport.keras.trainedmodels.TrainedModels
import org.nd4j.linalg.dataset.api.preprocessor.VGG16ImagePreProcessor
import org.deeplearning4j.zoo.model.VGG16
import org.deeplearning4j.zoo._


/**
  * Created by arturroo on 12.09.2017.
  * based on https://deeplearning4j.org/build_vgg_webapp
  * and https://blog.cloudera.com/blog/2017/06/deep-learning-on-apache-spark-and-hadoop-with-deeplearning4j/
  */


object Main {
  def main(args: Array[String]): Unit = {
    val zooModel = new VGG16()
    val vgg16:ComputationGraph = zooModel.initPretrained(PretrainedType.IMAGENET)
    val loader = new NativeImageLoader(224, 224, 3)
    val file = new File("tatry-wejscie-na-hale-gasienicowa_1079357.jpg")
    val image = loader.asMatrix(file)
    val scaler = new VGG16ImagePreProcessor()
    scaler.transform(image)

    // output
    val output = vgg16.output(false,image)
    println(TrainedModels.VGG16.decodePredictions(output(0)))
  }
}
