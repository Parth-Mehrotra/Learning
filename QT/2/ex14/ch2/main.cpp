#include <qapplication.h>

#include "ch2.h"

int main( int argc, char **argv )
{
	QApplication a( argc, argv );
	
	NeHeWidget *w = new NeHeChapter2();
	a.setMainWidget( w );
	w->show();
	
	return a.exec();
}
