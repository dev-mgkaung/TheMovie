package mk.padc.themovie

import mk.padc.themovie.mvp.presenters.impl.DetailPresenterImplTest
import mk.padc.themovie.mvp.presenters.impl.MainPresenterImplTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

// Runs all unit tests.
@RunWith(Suite::class)
@Suite.SuiteClasses(ExampleUnitTest::class,MainPresenterImplTest::class,
    DetailPresenterImplTest::class)
class UnitTestSuite